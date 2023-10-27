package controller

import (
	"fmt"

	"github.com/gofiber/fiber/v2"
	"github.com/rakesh1602/GoLang/tree/pss/service"
)

func Route(app *fiber.App){
	fmt.Print("Inside the controller")
	app.Post("/v1/practices/:practiceId/patients/:patientId/appointments", service.CreateAppointment)
	app.Get("/v1/practices/:practiceId/patients/:patientId/appointments", service.GetAppointments)
	app.Get("/v1/practices/:practiceId/patients/:patientId/appointments/:appointmentId", service.GetAppointmentByID)

	fmt.Print("Controller executed")

}