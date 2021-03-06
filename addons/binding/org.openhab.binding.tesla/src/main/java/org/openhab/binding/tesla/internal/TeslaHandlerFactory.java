/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.tesla.internal;

import static org.openhab.binding.tesla.TeslaBindingConstants.*;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.storage.StorageService;
import org.openhab.binding.tesla.handler.TeslaHandler;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;

/**
 * The {@link TeslaHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Karel Goderis - Initial contribution
 * @author Nicolai Grødum - Adding token based auth
 */
public class TeslaHandlerFactory extends BaseThingHandlerFactory {

	private StorageService storageService;

	private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections
			.singleton(THING_TYPE_MODELS);

	@Override
	public boolean supportsThingType(ThingTypeUID thingTypeUID) {
		return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
	}

	@Override
	protected ThingHandler createHandler(Thing thing) {

		ThingTypeUID thingTypeUID = thing.getThingTypeUID();

		if (thingTypeUID.equals(THING_TYPE_MODELS)) {
			return new TeslaHandler(thing, storageService);
		}

		return null;
	}

	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}

    public void unsetStorageService(StorageService storageService) {
        this.storageService = null;
    }
}
