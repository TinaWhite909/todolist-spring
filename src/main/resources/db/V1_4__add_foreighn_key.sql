ALTER TABLE tasklist
ADD FOREIGN KEY (status_id)
REFERENCES statuses (id);