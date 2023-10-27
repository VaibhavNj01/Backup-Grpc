package service

import (
    "github.com/gofiber/fiber/v2"
    "github.com/google/uuid"
    "github.com/rakesh1602/GoLang/tree/pss/config"
    "github.com/rakesh1602/GoLang/tree/pss/entity"
)

func GetAppointmentByID(c *fiber.Ctx) error {
    // Retrieve parameters such as practiceId, patientId, and appointmentId
    practiceId := c.Params("practiceId")
    patientId := c.Params("patientId")
    appointmentIdStr := c.Params("appointmentId")

    // Parse the appointmentId from the URL parameter into a UUID
    appointmentId, err := uuid.Parse(appointmentIdStr)
    if err != nil {
        return c.Status(400).JSON(fiber.Map{
            "error": "Invalid appointmentId format.",
        })
    }

    // Fetch appointment details based on appointmentId
    appointment := entity.AppointmentEntity{}
    result := config.DB.Where("practice_id = ? AND patient_id = ? AND appointment_id = ?", practiceId, patientId, appointmentId).First(&appointment)
    
    // Check if the appointment exists
    if result.Error != nil {
        return c.Status(404).JSON(fiber.Map{
            "error": "Appointment not found.",
        })
    }

    // Return the appointment details as a response
    return c.Status(200).JSON(fiber.Map{
        "success": true,
        "message": "Appointment details retrieved successfully.",
        "data":    appointment,
    })
}
