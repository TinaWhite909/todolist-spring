CREATE TABLE tasklist
(
    "TASK_ID" serial primary key,
    "START_DATE" date NOT NULL,
    "FINISH_DATE" date NOT NULL,
    "TASK" varchar(1000)
);