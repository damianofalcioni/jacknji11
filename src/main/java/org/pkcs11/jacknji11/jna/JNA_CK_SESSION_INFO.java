/*
 * Copyright 2010-2011 Joel Hockey (joel.hockey@gmail.com). All rights reserved.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.pkcs11.jacknji11.jna;

import java.util.List;

import org.pkcs11.jacknji11.CK_SESSION_INFO;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * JNA wrapper for PKCS#11 CK_SESSION_INFO struct.
 * @author Joel Hockey (joel.hockey@gmail.com)
 */
public class JNA_CK_SESSION_INFO extends Structure {
    public NativeLong slotID;
    public NativeLong state;
    public NativeLong flags;
    public NativeLong ulDeviceError;

    public JNA_CK_SESSION_INFO readFrom(CK_SESSION_INFO info) {
        slotID = new NativeLong(info.slotID);
        state = new NativeLong(info.state);
        flags = new NativeLong(info.flags);
        ulDeviceError = new NativeLong(info.ulDeviceError);
        return this;
    }

    public CK_SESSION_INFO writeTo(CK_SESSION_INFO info) {
        info.slotID = slotID.intValue();
        info.state = state.intValue();
        info.flags = flags.intValue();
        info.ulDeviceError = ulDeviceError.intValue();
        return info;
    }
    
    @Override
    protected List<String> getFieldOrder() {
        return java.util.Arrays.asList(new String[] {"slotID", "state", "flags", "ulDeviceError"});
    }
}
