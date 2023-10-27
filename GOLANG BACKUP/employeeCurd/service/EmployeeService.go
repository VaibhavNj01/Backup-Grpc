package service

import (
	"encoding/json"
	"log"
	"net/http"
	"vaibhav/database1"
	"vaibhav/model"

	"github.com/gorilla/mux"
)

func CreateEmployee(writer http.ResponseWriter, request *http.Request) {
	writer.Header().Set("content-type", "application/json")
	var employee model.Employee
	json.NewDecoder(request.Body).Decode(&employee)
	json.NewEncoder(writer).Encode(employee)
	db1 := database1.Connection()
	db1.Create(&employee)
	log.Println("data inserted successfully...( ` ^_^ ` )")
	
}
func GetAllEmployee(writer http.ResponseWriter, request *http.Request) {
	writer.Header().Set("content-type", "application/json")
	var employee []model.Employee
	db := database1.Connection()
	db.Find(&employee)
	err := json.NewEncoder(writer).Encode(employee)
	log.Println("data Get successfully...( ` ^_^ ` )")
	if err != nil {
		return
	}

}
func GetEmployeeById(writer http.ResponseWriter, request *http.Request) {
	writer.Header().Set("content-type", "application/json")
	db := database1.Connection()
	param := mux.Vars(request)
	var employee model.Employee
	db.First(&employee, param["empId"])
	json.NewEncoder(writer).Encode(employee)
	log.Println("employee get using Id successfully...( ` ^_^ ` )", +employee.ID)

}

func DeleteEmployee(writer http.ResponseWriter, request *http.Request) {
	writer.Header().Set("content-type", "application/json")
	db := database1.Connection()
	param := mux.Vars(request)
	var employee model.Employee
	db.First(&employee, param["empId"])
	db.Delete(&employee)
	json.NewEncoder(writer).Encode("delete success")
	log.Println("employee get using Id successfully...( ` ^_^ ` )")

}

func UpdateEmployee(writer http.ResponseWriter, request *http.Request) {
	writer.Header().Set("content-type", "application/json")
	var employee model.Employee
	db := database1.Connection()
	param := mux.Vars(request)
	db.First(&employee, param["empId"])
	json.NewDecoder(request.Body).Decode(&employee)
	db.Save(&employee)
	json.NewEncoder(writer).Encode(&employee)
}
