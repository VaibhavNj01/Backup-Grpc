package user

import "gorm.io/gorm"

var DB *gorm.DB
var err error



type User struct {
	gorm.Model
	FirstName string `json:"firstName"`
	LastgName string `json:"lastName"`
	Email string `json:"email"`
}