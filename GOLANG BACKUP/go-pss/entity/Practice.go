package entity

import "github.com/google/uuid"

type PracticeEntity struct {
	PracticeId   uuid.UUID `gorm:"primarykey" json:"practice_id,omitempty"`
	PracticeName string `gorm:"primaryKey" json:"practice_name,omitempty"`
}
