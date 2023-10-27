# Use the official PostgreSQL image

FROM postgres:latest

# Set environment variables for PostgreSQL

ENV POSTGRES_DB=postgres

ENV POSTGRES_USER=postgres

ENV POSTGRES_PASSWORD=@pass1234

# Copy the SQL scripts to the docker-entrypoint-initdb.d directory

COPY /dbscript/table.sql /docker-entrypoint-initdb.d/1_table.sql
COPY /dbscript/data.sql /docker-entrypoint-initdb.d/2_data.sql

EXPOSE 5432