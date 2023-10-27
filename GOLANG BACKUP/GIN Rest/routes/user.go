package routes
import (
	"github.com/gin-gonic/gin"
	"vaibhav/controller"
)

func UserRoute(router *gin.Engine){
	router.GET("/users",controller.GetUsers)
	router.POST("/users",controller.CreateUsers)
	router.PUT("/users/:id",controller.UpdateUsers)
	router.DELETE("/users/:id",controller.DeleteUsers)
	
	 
}