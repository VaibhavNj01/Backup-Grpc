package database1

import (
	"fmt"
	"os"
	"vaibhav/model"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

func Connection() *gorm.DB {

	var urls = os.Getenv("url")
	DB, err := gorm.Open(postgres.Open(urls), &gorm.Config{})
	if err != nil {
		fmt.Println(err)
	}
	if DB != nil {
		fmt.Println("database connection successful...( ` ^_^ ` )")
	}
	DB.AutoMigrate(model.Employee{})
	return DB
}
