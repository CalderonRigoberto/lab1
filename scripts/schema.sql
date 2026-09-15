\c  test;

CREATE TABLE public.events (
    id int8 NOT NULL,
    available_stock int4 NOT NULL,
    "version" int8 NULL,
    CONSTRAINT events_available_stock_not_null NOT NULL available_stock,
    CONSTRAINT events_id_not_null NOT NULL id,
    CONSTRAINT events_pkey PRIMARY KEY (id)
);

INSERT INTO public.events(id, available_stock, version)
VALUES (1, 50, 1);

CREATE TABLE public.bookings (
    id int4 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
    event_id int8 NOT NULL,
    user_id uuid DEFAULT gen_random_uuid() NULL,
    created_at timestamp DEFAULT now() NOT NULL,
    CONSTRAINT bookings_created_at_not_null NOT NULL created_at,
    CONSTRAINT bookings_event_id_not_null NOT NULL event_id,
    CONSTRAINT bookings_id_not_null NOT NULL id,
    CONSTRAINT bookings_pkey PRIMARY KEY (id)
);