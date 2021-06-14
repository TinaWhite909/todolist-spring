CREATE TABLE public.tasklist
(
    "TASK_ID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "START_DATE" date NOT NULL,
    "FINISH_DATE" date,
    "TASK" character varying(1000) COLLATE pg_catalog."default",
    CONSTRAINT tasklist_pkey PRIMARY KEY ("TASK_ID")
)