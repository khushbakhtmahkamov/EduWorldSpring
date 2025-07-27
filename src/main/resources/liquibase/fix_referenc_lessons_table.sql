ALTER TABLE lessons DROP COLUMN subject_id;
ALTER TABLE lessons
    ADD COLUMN subject_id BIGINT NOT NULL REFERENCES subjects(id);
ALTER TABLE lessons DROP COLUMN lesson_id;