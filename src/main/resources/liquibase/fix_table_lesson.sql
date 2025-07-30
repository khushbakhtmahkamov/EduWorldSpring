ALTER TABLE lessons DROP COLUMN start_date;
ALTER TABLE lessons
    ADD COLUMN start_date DATE;
ALTER TABLE lessons DROP COLUMN end_date;
ALTER TABLE lessons
    ADD COLUMN end_date DATE;