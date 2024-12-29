package org.example.homeworks.hw_01_12_24.laptop.util;

import org.bson.types.ObjectId;
import org.example.homeworks.hw_01_12_24.laptop.controller.Command;
import org.example.homeworks.hw_01_12_24.laptop.controller.impl.FindByRamCommand;
import org.example.homeworks.hw_01_12_24.laptop.controller.impl.GetAllLaptopCommand;
import org.example.homeworks.hw_01_12_24.laptop.domain.LaptopDocument;
import org.example.homeworks.hw_01_12_24.laptop.service.LaptopService;
import org.example.homeworks.hw_01_12_24.laptop.service.impl.LaptopServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.example.homeworks.hw_01_12_24.laptop.util.ConstantsUtil.*;

public class UtilData {

    public static final Map<String, Command> COMMANDS_MAP = new HashMap<>();

    static {

        LaptopService<LaptopDocument, ObjectId> laptopServiceMongoDB = new LaptopServiceImpl();

        COMMANDS_MAP.put(FIND_LAPTOP_BY_RAM, new FindByRamCommand(laptopServiceMongoDB));
        COMMANDS_MAP.put(FRONT_CONTROLLER_SERVLET, new GetAllLaptopCommand(laptopServiceMongoDB));

    }

}
