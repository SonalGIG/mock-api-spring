package com.hexa.service;


import java.util.List;

public interface ServiceProvider {

    /**
     * Create Service
     *
     * @param serviceRequest
     * @return
     */
    void createService(Service serviceRequest) throws Exception;

    /**
     * Return all mock services
     *
     * @return
     */
    List<MockMapping> getServices();

    /**
     * Delete mock service by uuid
     *
     * @param uuid
     */
    void deleteService(String uuid);

}
