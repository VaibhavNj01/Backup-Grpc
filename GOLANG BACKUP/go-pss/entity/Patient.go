package entity

import "github.com/google/uuid"

type PatientEntity struct {
	PatientId uuid.UUID `gorm:"primaryKey" json:"patient_id,omitempty"`

	PatientName string `json:"patient_name,omitempty"`
}
