INSERT INTO
  "Role" ("type")
VALUES
  ('admin');

INSERT INTO
  "Role" ("type")
VALUES
  ('member');

INSERT INTO
  "Workplace" ("floor", "table")
VALUES
  (1, 2);

INSERT INTO
  "Workplace" ("floor", "table")
VALUES
  (1, 4);

INSERT INTO
  "Workplace" ("floor", "table")
VALUES
  (2, 1);

INSERT INTO
  "PostOfficeBox" ("category")
VALUES
  ('xl');

INSERT INTO
  "PostOfficeBox" ("category")
VALUES
  ('m');

INSERT INTO
  "PostOfficeBox" ("category")
VALUES
  ('xs');

INSERT INTO
  "User" (
    "firstname",
    "lastname",
    "email",
    "password",
    "role_id"
  )
VALUES
  (
    'Alex',
    'Christen',
    'alexchristen@gmail.com',
    '1324',
    1
  );

INSERT INTO
  "User" (
    "firstname",
    "lastname",
    "email",
    "password",
    "role_id"
  )
VALUES
  (
    'David',
    'Bucher',
    'davidbucher@gmail.com',
    '1234',
    2
  );

INSERT INTO
  "Booking" (
    "start",
    "end",
    "bookingForWorkplace",
    "user_id",
    "postOfficeBox_id",
    "workplace_id"
  )
VALUES
  (
    '2022-12-15 08:00:0',
    '2022-12-16 08:00:0',
    true,
    2,
    1,
    1
  );

INSERT INTO
  "Booking" (
    "start",
    "end",
    "bookingForWorkplace",
    "user_id",
    "postOfficeBox_id",
    "workplace_id"
  )
VALUES
  (
    '2022-12-14 09:00:0',
    '2022-12-31 09:00:0',
    true,
    2,
    2,
    2
  );

INSERT INTO
  "Report" ("message", "date", "user_id")
VALUES
  (
    'Klimanlage ist zu schwierig zu bedienen',
    '2022-11-19',
    2
  );

INSERT INTO
  "Report" ("message", "date", "user_id")
VALUES
  (
    'Tisch 2 im Floor 1 ist beschädigt',
    '2004-11-19',
    2
  );