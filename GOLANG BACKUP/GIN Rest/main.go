package main

import (
	"github.com/gin-gonic/gin"
	"vaibhav/routes"
	"vaibhav/config"
)

func main(){
	router := gin.New()
	config.Connect()
	routes.UserRoute(router)
	router.Run(":8080")
} 