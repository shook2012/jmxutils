/**
 *  Copyright 2009 Martin Traverso
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package mt.jmx.guice;

import com.google.inject.Inject;
import com.google.inject.Injector;
import mt.jmx.MBeanExporter;

import javax.management.MBeanServer;
import java.util.Set;

class GuiceMBeanExporter
{
    @Inject
    public GuiceMBeanExporter(Set<Mapping> mappings, MBeanServer server, Injector injector)
    {
        MBeanExporter exporter = new MBeanExporter(server);

        for (Mapping mapping : mappings) {
            exporter.export(mapping.getName(), injector.getInstance(mapping.getKey()));
        }
    }
}
