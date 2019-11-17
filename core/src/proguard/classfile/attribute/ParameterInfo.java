/*
 * ProGuard -- shrinking, optimization, obfuscation, and preverification
 *             of Java bytecode.
 *
 * Copyright (c) 2002-2019 Guardsquare NV
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package proguard.classfile.attribute;

import proguard.classfile.Clazz;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.util.SimpleVisitorAccepter;

/**
 * Representation of a parameter, as defined in a method parameters
 * attribute.
 *
 * @author Eric Lafortune
 */
public class ParameterInfo extends SimpleVisitorAccepter
{
    public int u2nameIndex;
    public int u2accessFlags;


    /**
     * Creates an uninitialized ParameterInfo.
     */
    public ParameterInfo()
    {
    }


    /**
     * Creates an initialized ParameterInfo.
     */
    public ParameterInfo(int u2nameIndex,
                         int u2accessFlags)
    {
        this.u2nameIndex   = u2nameIndex;
        this.u2accessFlags = u2accessFlags;
    }


    /**
     * Returns the parameter name.
     */
    public String getName(Clazz clazz)
    {
        return clazz.getString(u2nameIndex);
    }


    /**
     * Applies the given constant pool visitor to the Utf8 constant that
     * represents the name of the parameter, if any.
     */
    public void nameConstantAccept(Clazz clazz, ConstantVisitor constantVisitor)
    {
        if (u2nameIndex != 0)
        {
            clazz.constantPoolEntryAccept(u2nameIndex, constantVisitor);
        }
    }
}