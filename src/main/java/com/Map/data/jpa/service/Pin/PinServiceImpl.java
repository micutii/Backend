/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Map.data.jpa.service.Pin;


import com.Map.data.jpa.domain.Pin;
import com.Map.data.jpa.domain.PinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
class PinServiceImpl implements PinService {

	@Autowired
	private PinRepository pinRepository;

	@Override
	public Pin getPin(int idPin) {
		return pinRepository.findById(idPin).get();
	}

	@Override
	public List<Pin> getPins() {
			return pinRepository.findAll();
	}


	@Override
	public boolean savePin(Pin pin) {
		 if(pinRepository.save(pin) != null){
		 	return true;
		 }
		 return false;
	}

	@Override
	public void removePin(int idPin) {
		pinRepository.deleteById(idPin);
	}

	@Override
	public List<Pin> getValidPins(){
		return pinRepository.findValidPins();
	}
}
