/**
 * Copyright (C) 2011 Akiban Technologies Inc.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
 */

package com.akiban.server.encoding;

import org.junit.Test;

public class TimestampEncoderTest extends LongEncoderTestBase {
    public TimestampEncoderTest() {
        super(EncoderFactory.TIMESTAMP,
              new TestElement[] {
                new TestElement("0", 0),                                // 1970-01-01 00:00:00
                new TestElement("1234567890", 1234567890),              // 2009-02-13 23:31:30
                new TestElement("2147483647", 2147483647),              // 2038-01-19 03:14:07
                new TestElement("530841600", new Integer(530841600)),   // 1986-10-28 00:00:00
                new TestElement("1302460440", new Long(1302460440))     // 2011-04-10 18:34:00
              });
    }

    
    @Test(expected=IllegalArgumentException.class)
    public void invalidNumber() {
        encodeAndDecode("20111zebra");
    }

    @Test(expected=IllegalArgumentException.class)
    public void noNumbers() {
        encodeAndDecode("zebra");
    }
}
