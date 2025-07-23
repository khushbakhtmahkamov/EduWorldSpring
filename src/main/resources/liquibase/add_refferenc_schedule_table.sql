ALTER TABLE schedules DROP COLUMN lesson_id;
ALTER TABLE schedules
    ADD COLUMN lesson_id BIGINT NOT NULL REFERENCES lessons(id);