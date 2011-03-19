/*
 * Copyright (c) 2011 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jme3.network.kernel;

import java.nio.ByteBuffer;
import java.util.Collection;

import com.jme3.network.Filter;

/**
 *  Defines the basic byte[] passing messaging
 *  kernel.
 *
 *  @version   $Revision$
 *  @author    Paul Speed
 */
public interface Kernel
{
    /**
     *  Initializes the kernel and starts any internal processing.
     */
    public void initialize();
    
    /**
     *  Gracefully terminates the kernel and stops any internal 
     *  daemon processing.  This method will not return until all
     *  internal threads have been shut down.
     */
    public void terminate() throws InterruptedException;

    /**
     *  Dispatches the data to all endpoints managed by the
     *  kernel that match the specified endpoint filter..  
     */ 
    public void broadcast( Filter<? super Endpoint> filter, ByteBuffer data, boolean reliable );
 
    /**
     *  Returns true if there are waiting envelopes.
     */   
    public boolean hasEnvelopes();
 
    /**
     *  Removes one envelope from the received messages queue or
     *  blocks until one is available.
     */   
    public Envelope read() throws InterruptedException;
    
    /**
     *  Removes and returnsn one endpoint event from the event queue or
     *  null if there are no endpoint events.     
     */
    public EndpointEvent nextEvent();     
}