package entity

import (
	"github.com/google/uuid"
)

type LocationEntity struct {
	LocationId   uuid.UUID   `gorm:"primaryKey" json:"location_id,omitempty"`
	LocationName string      `json:"location_name,omitempty"`
}
