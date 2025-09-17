package com.vans.backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import com.vans.backend.dto.ViajeDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConciertoDTO {
	private Integer concierto_id;
	private String direccion;
	private LocalDateTime fecha;
	private BandaDTO banda;
	private List<ViajeDTO> viajes;
}

