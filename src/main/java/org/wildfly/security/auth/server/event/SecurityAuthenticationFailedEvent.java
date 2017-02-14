/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2017 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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
package org.wildfly.security.auth.server.event;

import org.wildfly.security.auth.server.SecurityIdentity;

/**
 * An event to represent a failed authentication.
 *
 * @author <a href="mailto:darran.lofthouse@jboss.com">Darran Lofthouse</a>
 */
public final class SecurityAuthenticationFailedEvent extends SecurityAuthenticationEvent {

    /**
     * Constructor for a new instance.
     *
     * @param securityIdentity the {@link SecurityIdentity} that failed authentication.
     */
    public SecurityAuthenticationFailedEvent(SecurityIdentity securityIdentity) {
        super(securityIdentity, false);
    }

    @Override
    public <P, R> R accept(SecurityEventVisitor<P, R> visitor, P param) {
        return visitor.handleAuthenticationFailedEvent(this, param);
    }

}
