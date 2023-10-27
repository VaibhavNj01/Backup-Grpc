-- Create sequences for auto-incrementing IDs
CREATE SEQUENCE patient_id_seq START 1000;
CREATE SEQUENCE practice_id_seq START 1000;
CREATE SEQUENCE appointment_id_seq START 1000;

-- Create the Patient Information Table
CREATE TABLE patient_info (
    id INT PRIMARY KEY DEFAULT nextval('patient_id_seq'),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth DATE,
    gender VARCHAR(10),
    phone_number VARCHAR(15),
    email VARCHAR(255)
);

-- Create the Practice Information Table
CREATE TABLE practice_info (
    id INT PRIMARY KEY DEFAULT nextval('practice_id_seq'),
    practice_name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(15),
    email VARCHAR(255)
);

-- Create the Appointments Table
CREATE TABLE appointments (
    id INT PRIMARY KEY DEFAULT nextval('appointment_id_seq'),
    patient_id INT REFERENCES patient_info(id),
    practice_id INT REFERENCES practice_info(id),
    appointment_date_time TIMESTAMP,
    appointment_creation_date_time TIMESTAMP DEFAULT current_timestamp,  -- Auto-populate with the current timestamp
    status VARCHAR(20)
);
