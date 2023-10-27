package controller

import (
	"net/http"
	"vaibhav/service"

	"github.com/gorilla/mux"
)

func EmployeeController() {

	r := mux.NewRouter()

	r.HandleFunc("/employees", service.CreateEmployee).Methods("POST")
	r.HandleFunc("/employees/{empId}", service.GetEmployeeById).Methods("GET")
	r.HandleFunc("/employees", service.GetAllEmployee).Methods("GET")
	r.HandleFunc("/employees/{empId}", service.DeleteEmployee).Methods("DELETE")
	r.HandleFunc("/employees/{empId}", service.UpdateEmployee).Methods("PUT")

	http.ListenAndServe(":9090", r)

}
