package main

import (
	"fmt"

	"github.com/gofiber/fiber/v2"
	"github.com/gofiber/fiber/v2/middleware/cors"
	db "github.com/rakesh1602/GoLang/tree/pss/config"
	route "github.com/rakesh1602/GoLang/tree/pss/controller"
)

func main() {
	fmt.Print("PSS go lang service started.")

	app := fiber.New()
	app.Use(cors.New())
	db.Connection()
	route.Route(app)

	app.Listen(":8082")


}