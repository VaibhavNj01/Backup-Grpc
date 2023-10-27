package entity

import (
	"github.com/google/uuid"
)

type ProviderEntity struct {
	ProviderId   uuid.UUID   `gorm:"primaryKey" json:"provider_id,omitempty"`
	ProviderName string      `json:"provider_name,omitempty"`
}
