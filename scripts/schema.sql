CREATE TABLE events(
  id BIGINT PRIMARY KEY,
  available_stock INTEGER not null,
  version BIGINT
);


CREATE TABLE bookings(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    event_id BIGINT NOT NULL,
    user_id UUID DEFAULT gen_random_uuid(),
    created_at  TIMESTAMP NOT NULL  DEFAULT NOW()
);