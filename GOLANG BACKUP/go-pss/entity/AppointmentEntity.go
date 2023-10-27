package entity

import (
	"time"

	"github.com/google/uuid"
)

type AppointmentEntity struct {
	AppointmentId   uuid.UUID `gorm:"primaryKey" json:"appointment_id,omitempty"`
	Method          string    `json:"method,omitempty"`
	AppointmentType string    `json:"appointment_type,omitempty"`
	AppointmentDate time.Time `json:"appointment_date,omitempty"`
	SlotTime        string    `json:"slot_time,omitempty"`
	ProviderId      uuid.UUID `gorm:"foreignKey:ProviderId" json:"provider_id,omitempty"`
	LocationId      uuid.UUID `gorm:"foreignKey:LocationId" json:"location_id,omitempty"`
	PracticeId      uuid.UUID `gorm:"foreignKey:PractieId" json:"practice_id,omitempty"`
	PatientId       uuid.UUID `gorm:"foreignKey:PatientId" json:"patient_id,omitempty"`
}
