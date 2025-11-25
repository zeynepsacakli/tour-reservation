package com.bil372.tour_reservation.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initTriggers() {

        // Mevcut trigger'ları temizle (hataya düşmemesi için)
        jdbcTemplate.execute("DROP TRIGGER IF EXISTS trg_update_avg_after_insert");
        jdbcTemplate.execute("DROP TRIGGER IF EXISTS trg_update_avg_after_update");
        jdbcTemplate.execute("DROP TRIGGER IF EXISTS trg_update_avg_after_delete");

        // INSERT trigger
        jdbcTemplate.execute("""
            CREATE TRIGGER trg_update_avg_after_insert
            AFTER INSERT ON Review
            FOR EACH ROW
            BEGIN
                UPDATE Tour t
                JOIN (
                    SELECT tour_id, AVG(rating) AS new_avg
                    FROM Review
                    WHERE tour_id = NEW.tour_id
                    GROUP BY tour_id
                ) x ON x.tour_id = t.tour_id
                SET t.avg_rating = x.new_avg;
            END;
        """);

        // UPDATE trigger
        jdbcTemplate.execute("""
            CREATE TRIGGER trg_update_avg_after_update
            AFTER UPDATE ON Review
            FOR EACH ROW
            BEGIN
                UPDATE Tour t
                JOIN (
                    SELECT tour_id, AVG(rating) AS new_avg
                    FROM Review
                    WHERE tour_id = NEW.tour_id
                    GROUP BY tour_id
                ) x ON x.tour_id = t.tour_id
                SET t.avg_rating = x.new_avg;
            END;
        """);

        // DELETE trigger
        jdbcTemplate.execute("""
            CREATE TRIGGER trg_update_avg_after_delete
            AFTER DELETE ON Review
            FOR EACH ROW
            BEGIN
                UPDATE Tour t
                JOIN (
                    SELECT tour_id, AVG(rating) AS new_avg
                    FROM Review
                    WHERE tour_id = OLD.tour_id
                    GROUP BY tour_id
                ) x ON x.tour_id = t.tour_id
                SET t.avg_rating = x.new_avg;
            END;
        """);

        System.out.println("Triggers created successfully!");
    }
}
