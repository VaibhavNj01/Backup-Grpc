package main

import (
	"log"
	"raj/controller"

	"github.com/joho/godotenv"
)


func main() {

	log.Println("application started successfully.......")
	//load .env file
	err := godotenv.Load("app.env")
	if err != nil {
		return
	}

	//calling router(controller)
	controller.EmployeeController()

}
