package model

import "time"

type Appointment struct {
	Method          string    `json:"method,omitempty"`
	AppointmentType string    `json:"appointment_type,omitempty"`
	AppointmentDate time.Time `json:"appointment_date,omitempty"`
	SlotTime        string     `json:"slot_time,omitempty"`
	Provider        Provider  `json:"provider,omitempty"`
	Location        Location  `json:"location,omitempty"`
}
