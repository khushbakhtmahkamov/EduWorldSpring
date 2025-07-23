DROP Table category;
DROP Table task_answer;
DROP TABLE task;
DROP TABLE language;

ALTER TABLE subjects
    DROP COLUMN category_id;
ALTER TABLE subjects
    ADD COLUMN category_id BIGINT NOT NULL REFERENCES categories(id);