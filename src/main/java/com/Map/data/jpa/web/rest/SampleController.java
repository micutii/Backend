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

package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Pin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Map.data.jpa.service.Pin.PinService;

@Controller
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

	@Autowired
	private PinService pinService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<Pin> getCity(){
        Pin pin = pinService.getPin(1);
        if(pin == null)
        {
            return null;
        }
        return new ResponseEntity<Pin>(pin, HttpStatus.OK);
    }
}
