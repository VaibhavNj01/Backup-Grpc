package controller


import (
	"context"
	"net/http"
  
	"github.com/gin-gonic/gin"
	"vaibhav/GIN Rest/proto/user"
  )

  func GetUsers(c *gin.Context) {
	req := &user.Empty{}
	resp := &user.UserList{}
  
	// Call the UserService.GetUsers RPC method.
	err := example.UserService.GetUsers(context.Background(), req, resp)
	if err != nil {
	  c.JSON(http.StatusInternalServerError, err.Error())
	  return
	}
  
	// Marshal the protobuf response message to JSON.
	jsonBytes, err := proto.Marshal(resp)
	if err != nil {
	  c.JSON(http.StatusInternalServerError, err.Error())
	  return
	}
  
	// Write the JSON response to the client.
	c.JSON(http.StatusOK, jsonBytes)
  }
  
  func CreateUsers(c *gin.Context) {
	var user user.User
  
	// Bind the JSON request body to the protobuf message.
	err := c.BindJSON(&user)
	if err != nil {
	  c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
	  return
	}
  
	// Call the UserService.CreateUser RPC method.
	resp, err := example.UserService.CreateUser(context.Background(), &user)
	if err != nil {
	  c.JSON(http.StatusInternalServerError, err.Error())
	  return
	}
  
	// Write the JSON response to the client.
	
  