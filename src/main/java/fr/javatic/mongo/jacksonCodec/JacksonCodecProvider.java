/*
 * Copyright 2015 Yann Le Moigne
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

package fr.javatic.mongo.jacksonCodec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.RawBsonDocument;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class JacksonCodecProvider implements CodecProvider {
    private final ObjectMapper bsonObjectMapper;

    public JacksonCodecProvider(final ObjectMapper bsonObjectMapper) {
        this.bsonObjectMapper = bsonObjectMapper;
    }

    @Override
    public <T> Codec<T> get(final Class<T> type, final CodecRegistry registry) {
        return new JacksonCodec<>(bsonObjectMapper, registry, type);
    }
}
