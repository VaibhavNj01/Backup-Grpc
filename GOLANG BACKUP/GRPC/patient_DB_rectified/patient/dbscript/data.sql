-- Generate and insert data for the patient_info table
DO $$ 
DECLARE
    i INT;
BEGIN
    FOR i IN 1..10000 LOOP
        INSERT INTO patient_info (first_name, last_name, date_of_birth, gender, phone_number, email)
        VALUES 
        (
            'First_Name_' || i,
            'Last_Name_' || i,
            '1990-01-01'::DATE + (i || ' days')::INTERVAL,
            CASE WHEN random() > 0.5 THEN 'Male' ELSE 'Female' END,
            'Phone_' || i,
            'email_' || i || '@example.com'
        );
    END LOOP;
END $$;

-- Generate and insert data for the practice_info table
DO $$ 
DECLARE
    i INT;
BEGIN
    FOR i IN 1..10000 LOOP
        INSERT INTO practice_info (practice_name, address, phone_number, email)
        VALUES 
        (
            'Practice_' || i,
            'Address_' || i,
            'Phone_' || i,
            'practice_' || i || '@example.com'
        );
    END LOOP;
END $$;

-- Generate and insert data for the appointments table
DO $$ 
DECLARE
    i INT;
    j INT;
BEGIN
    j:= 1;
    FOR j IN 1..100 LOOP
        FOR i IN 1000..9999 LOOP
            INSERT INTO appointments (patient_id, practice_id, appointment_date_time, Status)
            VALUES 
            (
                i, -- Assuming Patient IDs start from 1
                i+j, -- Assuming Practice IDs start from 1
                current_timestamp + (j || ' days')::INTERVAL, -- Auto-populate AppointmentDateTime
                'Scheduled'
            );
        END LOOP;
    END LOOP;
END $$;