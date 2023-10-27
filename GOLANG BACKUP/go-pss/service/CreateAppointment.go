package service

import (
	"time"

	"github.com/gofiber/fiber/v2"
	"github.com/google/uuid"
	db "github.com/rakesh1602/GoLang/tree/pss/config"
	"github.com/rakesh1602/GoLang/tree/pss/entity"
	"github.com/rakesh1602/GoLang/tree/pss/mapper"
	"github.com/rakesh1602/GoLang/tree/pss/model"
)

func CreateAppointment(c *fiber.Ctx) error {
	// Get the practiceId and patientId parameters from the request.
	practiceId := c.Params("practiceId")
	patientId := c.Params("patientId")

	practiceUUID, err := uuid.Parse(practiceId)
	if err != nil {
		return nil
	}

	patientUUID, err := uuid.Parse(patientId)
	if err != nil {
		return nil
	}

	locationUUID, err := uuid.Parse("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
	providerUUID, err := uuid.Parse("6ba7b810-9dad-11d1-80b4-00c04fd431c9")
  
	// Check if the practice exists.
	var practice entity.PracticeEntity
	result := db.DB.First(&practice, "practice_id = ?", practiceId)
	if result.Error != nil {
	  return c.Status(400).JSON(fiber.Map{
		"error": "Practice Id not found.",
	  })
	}
  
	// Check if the patient exists.
	var patient entity.PatientEntity
	result = db.DB.First(&patient, "patient_id = ?", patientId)
	if result.Error != nil {
	  return c.Status(400).JSON(fiber.Map{
		"error": "Patient Id not found.",
	  })
	}
  
	// Validate the appointment date and time.
	appointmentModel := model.Appointment{}
	if err := c.BodyParser(&appointmentModel); err != nil {
	  return err
	}
  
	// Check if the appointment date is in the future.
	if appointmentModel.AppointmentDate.Before(time.Now()) {
	  return c.Status(422).JSON(fiber.Map{
		"error": "Appointment date must be in the future.",
	  })
	}

  
	// Convert the appointmentModel to an appointmentEntity.
	appointmentEntity := entity.AppointmentEntity{
		AppointmentId: uuid.New(),
		PracticeId: practiceUUID,
		PatientId: patientUUID,
		LocationId: locationUUID,
		ProviderId: providerUUID,

	}
	mapper.MapAppointmentModelToEntiy(appointmentModel, &appointmentEntity)
  
	// Create the appointment in the database.
	result = db.DB.Create(&appointmentEntity)
	if result.Error != nil {
	  return c.Status(500).JSON(fiber.Map{
		"error": "Error creating appointment.",
	  })
	}
  
	// Return the appointmentId to the client.
	return c.Status(200).JSON(fiber.Map{
	  "success":       true,
	  "message":       "Your appointment is book successfully, Your appointment id is :",
	  "appointmentId": appointmentEntity.AppointmentId,
	})
  }
