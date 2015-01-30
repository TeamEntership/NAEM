package com.entership.naem.items;

import net.minecraft.util.IStringSerializable;

public enum EnumRobotParts implements IStringSerializable
{
    WHOLE(0, 3, "whole", "whole"),
    REPAIRED(1, 2, "repaired", "repaired"),
    HALFED(2, 1, "halfed", "halfed"),
    BROKEN(3, 0, "broken", "broken");
    private static final EnumRobotParts[] META_LOOKUP = new EnumRobotParts[values().length];
    private static final EnumRobotParts[] DYE_DMG_LOOKUP = new EnumRobotParts[values().length];
    private final int meta;
    private final int dyeDamage;
    private final String name;
    private final String unlocalizedName;

    private EnumRobotParts(int meta, int dyeDamage, String name, String unlocalizedName)
    {
        this.meta = meta;
        this.dyeDamage = dyeDamage;
        this.name = name;
        this.unlocalizedName = unlocalizedName;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public int getDyeDamage()
    {
        return this.dyeDamage;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    public static EnumRobotParts byDyeDamage(int damage)
    {
        if (damage < 0 || damage >= DYE_DMG_LOOKUP.length)
        {
            damage = 0;
        }

        return DYE_DMG_LOOKUP[damage];
    }

    public static EnumRobotParts byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String toString()
    {
        return this.unlocalizedName;
    }

    public String getName()
    {
        return this.name;
    }

    static
    {
        EnumRobotParts[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2)
        {
            EnumRobotParts var3 = var0[var2];
            META_LOOKUP[var3.getMetadata()] = var3;
            DYE_DMG_LOOKUP[var3.getDyeDamage()] = var3;
        }
    }
}