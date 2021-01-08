/*
 * Copyright (C) 2021 by Sebastian Hasait (sebastian at hasait dot de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.hasait.cipa.resource

import com.cloudbees.groovy.cps.NonCPS
import de.hasait.cipa.CipaNode

/**
 *
 */
class CipaCustomResource implements CipaResource, Serializable {

	private final CipaNode node
	private final String type
	private final String id

	def runtime = [:]

	CipaCustomResource(CipaNode node, String type, String id) {
		if (!type) {
			throw new IllegalArgumentException('type is null or empty')
		}
		if (!id) {
			throw new IllegalArgumentException('id is null or empty')
		}

		this.node = node
		this.type = type
		this.id = id
	}

	@Override
	@NonCPS
	CipaNode getNode() {
		return node
	}

	@NonCPS
	String getType() {
		return type
	}

	@NonCPS
	String getId() {
		return id
	}

	@Override
	@NonCPS
	String toString() {
		if (node) {
			return "Resource[${type}:${id}] on ${node}"
		}
		return "Global Resource[${type}:${id}]"
	}

}
