package com.a406.horsebit.service;

import java.util.List;

import com.a406.horsebit.domain.Token;
import com.a406.horsebit.dto.HorseDTO;
import com.a406.horsebit.dto.TokenDTO;
import com.a406.horsebit.dto.VolumeDTO;

public interface TokenService {
	List<TokenDTO> findAllTokens();
	List<TokenDTO> findTokens(List<Long> tokensNo);
	List<Long> findPossessTokens(Long userNo);
	TokenDTO findTokenDetail(Long tokenNo);
	List<VolumeDTO> findTokenVolumes(Long tokenNo);
	HorseDTO findHorse(Long tokenNo);
}
