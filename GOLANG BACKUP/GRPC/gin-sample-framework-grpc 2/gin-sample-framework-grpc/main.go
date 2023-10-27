package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()

	r.GET("/", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"message": "Hello, Nilesh working on Gin! Get Call"})
	})

	r.POST("/service", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"message": "Hello, Nilesh working on Gin! Post Call"})
	})

	r.HEAD("/validate", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"message": "Hello, Nilesh working on Gin! Head Call"})
	})

	r.DELETE("/delete", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"message": "Hello, Nilesh working on Gin! delete Call"})
	})

	r.Run(":8080")
}
