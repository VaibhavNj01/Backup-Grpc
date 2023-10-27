package service

import (
		"log"
	"time"

	"github.com/gofiber/fiber/v2"
		db "github.com/rakesh1602/GoLang/tree/pss/config"
	"github.com/rakesh1602/GoLang/tree/pss/entity"
	"gorm.io/gorm"
)

func GetAppointments(c *fiber.Ctx) error {
	practiceId := c.Params("practiceId")
	patientId := c.Params("patientId")
	appointmentType := c.Query("type")
	startDateStr := c.Query("startdate")

	// Convert startDateStr and endDateStr to time.Time objects
	var startDate time.Time
	log.Print(startDate)
	if startDateStr != "" {
		startDate, _ = time.Parse("2006-01-02", startDateStr)
	}

	// Determine the filter for upcoming or past appointments based on the "type" query parameter
	var filter func(db *gorm.DB) *gorm.DB
	switch appointmentType {
	case "upcoming":
		filter = func(db *gorm.DB) *gorm.DB {
			return db.Where("practice_id = ? AND patient_id = ? AND appointment_date >= ?", practiceId, patientId, time.Now())
		}
	case "past":
		filter = func(db *gorm.DB) *gorm.DB {
			return db.Where("practice_id = ? AND patient_id = ? AND appointment_date < ?", practiceId, patientId, time.Now())
		}
	default:
		return c.Status(400).JSON(fiber.Map{
			"error": "Invalid 'type' query parameter. Use 'upcoming' or 'past'.",
		})
	}

	// Query the database based on the filter
	var appointments []entity.AppointmentEntity
	result := db.DB.Scopes(filter).Find(&appointments)
	if result.Error != nil {
		return c.Status(500).JSON(fiber.Map{
			"error": "Error querying the database.",
		})
	}

	//TODO: Pagination logic
	return c.Status(200).JSON(fiber.Map{
		"success": true,
		"message": "Appointments retrieved successfully.",
		"data":    appointments,
	})
}
