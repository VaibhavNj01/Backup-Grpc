package mapper

import (
	"github.com/rakesh1602/GoLang/tree/pss/entity"
	"github.com/rakesh1602/GoLang/tree/pss/model"
)

func MapAppointmentModelToEntiy(modelAppointment model.Appointment, entityAppointment *entity.AppointmentEntity) {
	entityAppointment.Method = modelAppointment.Method
	entityAppointment.AppointmentType = modelAppointment.AppointmentType
	entityAppointment.AppointmentDate = modelAppointment.AppointmentDate
	entityAppointment.SlotTime = modelAppointment.SlotTime
	

}