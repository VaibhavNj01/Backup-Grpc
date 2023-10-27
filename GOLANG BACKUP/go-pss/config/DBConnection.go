package config

import (
	"fmt"
	"os"

	"github.com/joho/godotenv"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
	"gorm.io/gorm/logger"
	entity "github.com/rakesh1602/GoLang/tree/pss/entity"
)

var DB *gorm.DB

func Connection() {

	godotenv.Load()
	dbhost := os.Getenv("POSTGRES_HOST")
	dbuser := os.Getenv("POSTGRES_USER")
	dbpassword := os.Getenv("POSTGRES_PASSWORD")
	dbname := os.Getenv("POSTGRES_DBNAME")
	dbport := os.Getenv("POSTGRES_PORT")

	dsn := fmt.Sprintf("host=%s user=%s password=%s dbname=%s port=%s sslmode=disable TimeZone=Asia/Shanghai", dbhost, dbuser, dbpassword, dbname, dbport)

	db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{
		Logger: logger.Default.LogMode(logger.Info),
	})

	if err != nil {
		panic("Connection to the database is failed")
	}

	DB = db
	fmt.Println("Connection to the database is sucessfull.")

	AutoMigrate(db)

}

func AutoMigrate(connection *gorm.DB) {
	connection.Debug().AutoMigrate(
		&entity.AppointmentEntity{},
	)
}
