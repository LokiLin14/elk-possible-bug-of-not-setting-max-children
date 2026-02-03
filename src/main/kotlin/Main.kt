package com.group7

import org.eclipse.elk.alg.layered.options.CycleBreakingStrategy
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider
import org.eclipse.elk.alg.layered.options.LayeredOptions
import org.eclipse.elk.alg.layered.options.OrderingStrategy
import org.eclipse.elk.core.RecursiveGraphLayoutEngine
import org.eclipse.elk.core.data.LayoutMetaDataService
import org.eclipse.elk.core.options.CoreOptions
import org.eclipse.elk.core.options.HierarchyHandling
import org.eclipse.elk.core.util.BasicProgressMonitor
import org.eclipse.elk.graph.ElkNode
import org.eclipse.elk.graph.util.ElkGraphUtil

fun setElkContainerNodeProperties(elkNode: ElkNode) {
    elkNode.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.layered")
    // Setting either of CONSIDER_MODEL_ORDER_STRATEGY or CYCLE_BREAKING_STRATEGY triggers the exception codepath
    elkNode.setProperty(LayeredOptions.CONSIDER_MODEL_ORDER_STRATEGY, OrderingStrategy.PREFER_NODES)
    elkNode.setProperty(LayeredOptions.CYCLE_BREAKING_STRATEGY, CycleBreakingStrategy.MODEL_ORDER)
    elkNode.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
}

fun main() {
    LayoutMetaDataService.getInstance().registerLayoutMetaDataProviders(LayeredMetaDataProvider())

    val elkGraphRoot: ElkNode = ElkGraphUtil.createGraph()
    val nodeA = ElkGraphUtil.createNode(elkGraphRoot)
    val nodeB = ElkGraphUtil.createNode(nodeA)

    setElkContainerNodeProperties(elkGraphRoot)
    setElkContainerNodeProperties(nodeA)

    RecursiveGraphLayoutEngine().layout(elkGraphRoot, BasicProgressMonitor())
}